package tilingTypes.NC5.Iso;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_25a
   extends TilingType
{
   public TilingTypeNC5_25a(){
      super( "NC5-25a", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 50, 30};
      paramName = new String[]{ "Indent Width", "Indent Height" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 4,3, 0,3,4, 0},
            {0, 1,0, 1,0,4, 1},
            {0, 4,3, 2,3,4, 1},
      };
      info = "a=c+d\nb=c\nA=B\nD+E=360\n(A+B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .8;
      double w = ln*paramValues[0]/200.;
      double h = Math.sqrt(ln*ln-w*w);
      double ih = h * paramValues[1]/100;
      double iw = w*ih/h;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln,  0);
      baseTile.setPoint(2,ln-w,  h);
      baseTile.setPoint(3,ln-w-iw, h-ih);
      baseTile.setPoint(4, w+iw, h+ih);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(1)-tiles[0].getX(2);
      offsets[1] = tiles[1].getY(1)-tiles[0].getY(2);
      offsets[2] = tiles[2].getX(2)-tiles[0].getX(0);
      offsets[3] = tiles[2].getY(2)-tiles[0].getY(0);
   }
}
