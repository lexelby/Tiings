package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_106
   extends TilingType
{
   public TilingTypeNC5_106(){
      super( "NC5-106", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 60, 50};
      paramName = new String[]{ "Aspect", "Indent" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,2, 0,1,2, 1},
            {0, 0,1, 1,0,1, 0},
            {1, 1,2, 2,1,2, 1},

            {0, 3,2, 0,4,3, 1},
            {1, 1,2, 4,1,2, 0},
            {0, 0,1, 5,0,1, 1},
            {1, 1,2, 6,1,2, 0},
      };
      info = "a=d\ne=2d\nB=90\nD+E=360\n(A+C=90)";
   }

   public void recalcBase(double[] paramValues) {
      double w = 2 * paramValues[0]/100.;
      double h = 2 - w;

      double maxy = Math.min(h*3/4, w*w/h/4);
      double miny = Math.max(-h/4, -3*w*w/h/4);
      double dy = (maxy-miny) * paramValues[1]/100. + miny;
      double dx = dy * h/w;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w,  0);
      baseTile.setPoint(2,  w,  h);
      baseTile.setPoint(3, w*3/4+dx, h*3/4-dy);
      baseTile.setPoint(4, w/4-dx, h/4+dy);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[6].getX(4)-tiles[2].getX(3);
      offsets[3] = tiles[6].getY(4)-tiles[2].getY(3);
   }
}
