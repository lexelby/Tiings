package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_10b
   extends TilingType
{
   public TilingTypeNC5_10b(){
      super( "NC5-10b", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,360};
      paramDef = new int[]{ 65,140};
      paramName = new String[]{"Aspect", "Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {1, 3,2, 1,2,3, 1},
            {0, 0,1, 2,0,1, 0},

            {0, 3,4, 0,4,0, 1},
            {1, 0,1, 4,0,1, 0},
            {1, 3,2, 5,2,3, 0},
            {0, 0,1, 6,0,1, 1},
      };
      info = "a=c=d=e\nC+E=360\n2B+C+D=360\n(A+B+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lntotal = 1.8;
      double w = lntotal * getParam(paramValues, 0)/100;
      double h = lntotal - w;
      
      double d = 2 * Math.atan2(w/2,h)/DEG2RAD;
      double e = getParam(paramValues, 1);
      if( e<d ) e = d;
      if( e>360-d) e = 360-d;
      if( e<90-d/2 ) e = 90-d/2;
      if( e>270+d/2 ) e = 270+d/2;
      double diag = Math.sqrt(h*h+w*w/4);
      double ln = diag/2/Math.sin(e/2 * DEG2RAD);
      double a = 180-(d+e)/2;

      double x4 = ln * Math.cos(a * DEG2RAD); 
      double y4 = ln * Math.sin(a * DEG2RAD);
      double x3 = x4 + ln * Math.cos((a+e-180) * DEG2RAD); 
      double y3 = y4 + ln * Math.sin((a+e-180) * DEG2RAD);
      double x2 = x3 + ln * Math.cos((a+e+d) * DEG2RAD); 
      double y2 = y3 + ln * Math.sin((a+e+d) * DEG2RAD);
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(0)-tiles[0].getX(3);
      offsets[1] = tiles[0].getY(0)-tiles[0].getY(3);
      offsets[2] = tiles[7].getX(3)-tiles[3].getX(4);
      offsets[3] = tiles[7].getY(3)-tiles[3].getY(4);
   }
}
