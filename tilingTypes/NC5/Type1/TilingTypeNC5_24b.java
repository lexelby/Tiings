package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_24b
   extends TilingType
{
   public TilingTypeNC5_24b(){
      super( "NC5-24b", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{100,100,100};
      paramDef = new int[]{ 50, 30, 50};
      paramName = new String[]{ "Aspect", "Indent Width", "Indent Height" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,3, 0,3,4, 0},
            {0, 0,1, 1,0,1, 1},
            {1, 4,3, 2,3,4, 1},

            {0, 2,1, 0,1,2, 0},
            {1, 4,3, 4,3,4, 0},
            {0, 0,1, 5,0,1, 1},
            {1, 4,3, 6,3,4, 1},
      };
      info = "a=c+d\nA=B\nD+E=360\n(A+B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = 2.*paramValues[0]/100.;
      double h = (2-ln)/2;
      double w = ln * paramValues[1]/200;
      double ih = h * paramValues[2]/100;
      double iw = w*ih/h;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln, 0);
      baseTile.setPoint(2, ln-w, h);
      baseTile.setPoint(3, ln-w-iw, h-ih);
      baseTile.setPoint(4, w+iw, h+ih);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[4].getX(0)-tiles[1].getX(2);
      offsets[3] = tiles[4].getY(0)-tiles[1].getY(2);
   }
}
