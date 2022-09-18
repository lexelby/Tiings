package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_76c
   extends TilingType
{
   public TilingTypeNC5_76c(){
      super( "NC5-76c: Split square", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{100,100,100};
      paramDef = new int[]{ 61, 18, 30};
      paramName = new String[]{ "Indent X", "Indent Y", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 2,0, 0,0,2, 0},
            {1, 2,1, 1,0,1, 0},
            {1, 2,0, 2,0,2, 0},
      };
      info = "a=d\nb=c\nB=90\nD+E=360\n(A+C=90)";
   }

   public void recalcBase(double[] paramValues) {
      double w = .7;
      double h = w;
      double dx = paramValues[0]/100.;
      double dy = paramValues[1]/100.;

      double xp = w*(dx+dy);
      double yp = h*(dy-dx);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w, -h);
      baseTile.setPoint(2,w+w,  0);
      baseTile.setPoint(3,w+w-xp,-yp);
      baseTile.setPoint(4, xp, yp);
   }
   public void recalcOffsets(double[] paramValues) {
      double os = paramValues[2]/100.;
      offsets[0] = tiles[3].getX(1)-tiles[0].getX(1);
      offsets[1] = tiles[3].getY(1)-tiles[0].getY(1);
      offsets[2] = tiles[0].getX(2)-tiles[0].getX(0) + os * offsets[0];
      offsets[3] = tiles[0].getY(2)-tiles[0].getY(0) + os * offsets[1];
   }
}
