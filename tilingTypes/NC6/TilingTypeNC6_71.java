package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_71
   extends TilingType
{
   public TilingTypeNC6_71(){
      super( "NC6-71", 6, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{180};
      paramDef = new int[]{ 80};
      paramName = new String[]{"Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,1,2, 0},
            {1, 0,3, 1,3,0, 0},
            {0, 1,2, 2,1,0, 0},

            {0, 2,4, 0,4,0, 1},
            {1, 1,0, 4,1,2, 1},
            {1, 0,3, 5,3,0, 1},
            {0, 1,2, 6,1,0, 1},
      };
      info = "b=c=d=f\na=e\nD=E\nE+F=360\n2B+C=360\n(A+D=B)";
   }
   
   public void recalcBase(double[] paramValues) {
      double ln = 0.8;

      double c = getParam(paramValues, 0);
      double b = 180-c/2;
      double ang1 = 90-b/2;
      double ang2 = c-ang1;

      double c1 =  ln * Math.cos(ang1 * DEG2RAD);
      double s1 =  ln * Math.sin(ang1 * DEG2RAD);
      double c2 =  ln * Math.cos(ang2 * DEG2RAD);
      double s2 =  ln * Math.sin(ang2 * DEG2RAD);
      
      double x1 =  c1;
      double y1 = -s1;
      double x2 = 2*c1;
      double y2 = 0;
      double x3 = 2*c1-c2;
      double y3 = s2;
      double x4 = c1;
      double y4 = s2;
      double x5 = c1-c2;
      double y5 = 0;
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
      baseTile.setPoint(5, x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[7].getX(4)-tiles[3].getX(0);
      offsets[3] = tiles[7].getY(4)-tiles[3].getY(0);
   }
}